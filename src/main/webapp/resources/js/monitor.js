$(document).ready(function () {
    connect();
});

var stompClient = null;
var countReconnect = 0;

function connect() {
    var socket = new SockJS('/monitor-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, connectCallBack, errorCallback);
    socket.onclose = function() {
        console.log('Conexão encerrada');
        reconnect();
    };
}

function reconnect() {
    console.log("Reconectando " + countReconnect + " tentativa");
    if (stompClient !== null) {
        stompClient.disconnect();
    }

    if (countReconnect < 100) {
        sleep(10000);
        connect();
    }
    countReconnect++;
}

function listenerEvento() {
    PrimeFaces.ajax.Request.handle({
        formId:'monitorEventos',
        source:'monitorEventos',
        process:'monitorEventos',
        update:'monitorEventos'
    });
}

function listenerOcorrencia() {

}

var connectCallBack = function (frame) {
    countReconnect = 0;
    stompClient.subscribe('/topic/eventos', function () {
        listenerEvento();
    });
    stompClient.subscribe('/topic/ocorrencias', function () {
        listenerOcorrencia();
    });
}

var errorCallback = function(error) {
    console.log('Erro de comunicação: ' + error);
};

function sleep(ms) {
    var start = new Date().getTime(), expire = start + ms;
    while (new Date().getTime() < expire) { }
}