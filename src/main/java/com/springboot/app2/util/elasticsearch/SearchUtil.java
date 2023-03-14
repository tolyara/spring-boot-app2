package com.springboot.app2.util.elasticsearch;

import com.springboot.app2.dto.elasticsearch.SearchRequestDto;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

public final class SearchUtil {

    private SearchUtil() {}

    public static SearchRequest buildSearchRequest(String indexName, SearchRequestDto dto) {
        try {
            int page = dto.getPage();
            int size = dto.getSize();
            int from = page == 0 ? 0 : page * size;

            SearchSourceBuilder builder = new SearchSourceBuilder()
                    .from(from)
                    .size(size)
                    .postFilter(getQueryBuilder(dto));

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

    public static SearchRequest buildSearchRequest(String indexName, String field, Date date) {
        try {
            SearchSourceBuilder builder = new SearchSourceBuilder().postFilter(getQueryBuilder(field, date));

            SearchRequest request = new SearchRequest(indexName);
            request.source(builder);
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SearchRequest buildSearchRequest(String indexName, SearchRequestDto dto, Date date) {
        try {
            final QueryBuilder baseSearchQueryBuilder = getQueryBuilder(dto);
            final QueryBuilder dateQueryBuilder = getQueryBuilder("created", date);

            final BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
//                    .must(baseSearchQueryBuilder)
                    .mustNot(baseSearchQueryBuilder)
                    .must(dateQueryBuilder);

            SearchSourceBuilder builder = new SearchSourceBuilder().postFilter(boolQueryBuilder);

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

    private static QueryBuilder getQueryBuilder(String field, Date date) {
        return QueryBuilders.rangeQuery(field).gte(date);
    }

}
