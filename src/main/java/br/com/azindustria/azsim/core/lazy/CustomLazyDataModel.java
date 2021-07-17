package br.com.azindustria.azsim.core.lazy;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomLazyDataModel<T, ID, R extends PagingAndSortingRepository<T, ID>> extends LazyDataModel<T> {

    @Autowired
    R repository;

    @Override
    public List<T> load(int first, int pageSize, Map<String, SortMeta> sortMap, Map<String, FilterMeta> filterMap) {
        PageRequest pageRequest = PageRequest.of((first / pageSize), pageSize);
        Page<T> page = repository.findAll(pageRequest);
        setRowCount((int) page.getTotalElements());
        return page.getContent();
    }
}
