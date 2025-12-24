package com.example.usermanagement.dto;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageResponse<T> {
    private List<T> items;
    private PageMeta meta;

    public PageResponse(List<T> items, PageMeta meta) {
        this.items = items;
        this.meta = meta;
    }

    public List<T> getItems() {
        return items;
    }

    public PageMeta getMeta() {
        return meta;
    }

    public static <T> PageResponse<T> from(Page<T> page) {
        PageMeta meta = new PageMeta(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages());

        return new PageResponse<>(page.getContent(), meta);
    }
}
