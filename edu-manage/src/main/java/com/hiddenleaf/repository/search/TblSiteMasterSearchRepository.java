package com.hiddenleaf.repository.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.hiddenleaf.document.SitesMaster;

/**
 * Spring Data Elasticsearch repository for the SitesMaster document.
 */
public interface TblSiteMasterSearchRepository extends ElasticsearchRepository<SitesMaster, String> {
}
