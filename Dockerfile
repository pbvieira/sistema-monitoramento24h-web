FROM registry.access.redhat.com/ubi8/ubi-minimal

USER root

RUN microdnf --setopt=tsflags=nodocs install -y tar gzip \
    && microdnf clean all \
    && rpm -q tar gzip

RUN curl --retry 3 --retry-delay 1 -O https://download.java.net/java/GA/jdk15.0.2/0d1cfde4252546c6931946de8db48ee2/7/GPL/openjdk-15.0.2_linux-x64_bin.tar.gz \
    && echo "91ac6fc353b6bf39d995572b700e37a20e119a87034eeb939a6f24356fbcd207 openjdk-15.0.2_linux-x64_bin.tar.gz" | sha256sum --check

RUN tar -xzf /openjdk-15.0.2_linux-x64_bin.tar.gz \
    && mkdir -p /usr/lib/jvm && mv jdk-15.0.2 /usr/lib/jvm/openjdk-15.0.2 \
    && rm -f /openjdk-15.0.2_linux-x64_bin.tar.gz

ARG SPRING_PROFILES_ACTIVE
ARG JAVA_OPTS
ARG DEBUG_OPTS
ARG PORT

ENV JAVA_HOME /usr/lib/jvm/openjdk-15.0.2
ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE}
ENV JAVA_OPTS ${JAVA_OPTS}
ENV JAVA_AGENTE ${JAVA_AGENTE}
ENV DEBUG_OPTS ${DEBUG_OPTS}
ENV PORT ${PORT:-8080}

EXPOSE ${PORT}

VOLUME /tmp

ADD /target/*.jar /opt/app.jar

ENV PATH="$PATH:$JAVA_HOME/bin"

CMD java ${JAVA_OPTS} ${DEBUG_OPTS} ${JAVA_AGENTE} -Djava.security.egd=file:/dev/./urandom -jar /opt/app.jar
