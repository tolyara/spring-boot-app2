package com.springboot.app2.util.elasticsearch;

import com.springboot.app2.dto.elasticsearch.SearchRequestDto;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.util.CollectionUtils;

import java.util.List;

public final class SearchUtil {

    private SearchUtil() {}

    public static SearchRequest buildSearchRequest(String indexName, SearchRequestDto dto) {
        try {
            SearchSourceBuilder builder = new SearchSourceBuilder().postFilter(getQueryBuilder(dto));

            if (dto.getSortBy() != null) {
                SortOrder sortOrder = dto.getOrder() != null ? dto.getOrder() : SortOrder.ASC;
                builder = builder.sort(dto.getSortBy(), sortOrder);
            }

            SearchRequest request = new SearchRequest(indexName);
            request.source(builder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static QueryBuilder getQueryBuilder(SearchRequestDto dto) {
        if (dto == null || CollectionUtils.isEmpty(dto.getFields())) return null;

        List<String> fields = dto.getFields();
        if (fields.size() > 1) {
            MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(dto.getSearchItem())
                    .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                    .operator(Operator.AND); // Operator.OR by default
            fields.forEach(queryBuilder::field);
            return queryBuilder;
        }

        // if we have only one field
        return fields.stream().findFirst()
                .map(field -> QueryBuilders.matchQuery(field, dto.getSearchItem()).operator(Operator.AND)).orElse(null);
    }

}
