package com.base.movingwalls.repository;

import com.base.movingwalls.model.campaign.Campaign;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CampaignRepositoryEntityManagedImpl implements CampaignRepositoryEntityManaged {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void refresh(Campaign campaign) {
        em.refresh(campaign);
    }

    public List<Campaign> dummyCampaignData() {

        return Arrays.asList(new Campaign("UA Sports Singapore", "01 APR - 31 APR 2019", "Published", LocalDateTime.now().minusMonths(2), LocalDateTime.now().minusMonths(1), "Download Report"),
                new Campaign("Nespresso", "01 APR - 31 APR 2019", "Processing", LocalDateTime.now().minusDays(25), LocalDateTime.now().minusDays(10), "Available in 2 Days"),
                new Campaign("DBS - 3 Bill Boards", "01 APR - 31 APR 2019", "Processing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Available in 4 Days"),
                new Campaign("Focus Media", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Ending in 23 Days"),
                new Campaign("Rendezvous - Bill Boards", "01 APR - 31 APR 2019", "Archived", LocalDateTime.now(), LocalDateTime.now().plusDays(20), "Download Report"),
                new Campaign("Orchard - 3 Bill Boards", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("Nespresso - 3 Bill Boards", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().plusMonths(4), LocalDateTime.now().plusMonths(5), "Ending in 23 Days"),
                new Campaign("Bizzare ", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("EA - Sports", "01 APR - 31 APR 2019", "Archived", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Download Report"),
                new Campaign("UA Sports Singapore", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("Bill Boards NewYork", "01 APR - 31 APR 2019", "Processing", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Available in 6 Days"),
                new Campaign("Hacker Boards", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().plusMonths(4), LocalDateTime.now().plusMonths(5), "Ending in 23 Days"),
                new Campaign("Campaign Data", "01 APR - 31 APR 2019", "Published", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Download Report"),
                new Campaign("Mars Mission", "01 APR - 31 APR 2019", "Processing", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Available in 23 Days"),
                new Campaign("Emperor Boards", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("YRS Bill Boards", "01 APR - 31 APR 2019", "Processing", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Available in 23 Days"),
                new Campaign("Zoom Network", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("Mission Campaign", "01 APR - 31 APR 2019", "Archived", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Download Report"),
                new Campaign("Hall Of Wars", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("Reactive Push", "01 APR - 31 APR 2019", "Published", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Download Reports"),
                new Campaign("Mines - 1 Bill Boards", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().plusMonths(4), LocalDateTime.now().plusMonths(5), "Ending in 23 Days"),
                new Campaign("Knowledge Entertainment", "01 APR - 31 APR 2019", "Archived", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Dowload Report"),
                new Campaign("Campaign Critical", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("Orchard - 3 Bill Boards", "01 APR - 31 APR 2019", "Published", LocalDateTime.now().plusMonths(4), LocalDateTime.now().plusMonths(5), "Download Report"),
                new Campaign("Hall of Fame", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"),
                new Campaign("Nespresso", "01 APR - 31 APR 2019", "Processing", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Available in 23 Days"),
                new Campaign("UA Sports", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().plusMonths(1), LocalDateTime.now().plusMonths(2), "Ending in 23 Days"),
                new Campaign("Data Campaign", "01 APR - 31 APR 2019", "Published", LocalDateTime.now().minusMonths(3), LocalDateTime.now().minusMonths(1), "Download Report"),
                new Campaign("Orchard Campaign", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(9), LocalDateTime.now().minusMonths(7), "Ending in 23 Days"),
                new Campaign("Horse Force", "01 APR - 31 APR 2019", "Processing", LocalDateTime.now().plusMonths(4), LocalDateTime.now().plusMonths(2), "Available in 23 Days"),
                new Campaign("Electrical Campaign", "01 APR - 31 APR 2019", "Ongoing", LocalDateTime.now().minusMonths(4), LocalDateTime.now().minusMonths(2), "Ending in 23 Days"));
    }

    public void createDummyCampaign() {
        dummyCampaignData().stream().forEach(campaign -> {
            em.persist(campaign);
            em.flush();
        });
    }

    public int initIndex() throws InterruptedException {

        final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer()
                .startAndWait();
        fullTextEntityManager.flushToIndexes();
        int indexSize = fullTextEntityManager.getSearchFactory()
                .getStatistics()
                .getNumberOfIndexedEntities(Campaign.class.getName());

        System.out.println("Campaign Size :: " + (dummyCampaignData().size() - 1) + "Index Size" + indexSize);
        return indexSize;
    }

    private QueryBuilder getQueryBuilder() {

        final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);

        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Campaign.class)
                .get();
    }

    public List<Campaign> searchByCampaignData(final String searchText) {

        final Query keywordQuery = getQueryBuilder()
                .keyword()
                .onFields("name", "duration", "status", "report")
                .matching(searchText)
                .createQuery();

        final List<Campaign> results = getJpaQuery(keywordQuery).getResultList();
        System.out.println(results);
        return results;
    }

    public List<Campaign> fetchAllCampaignData() {
        final Query keywordQuery = getQueryBuilder().all().createQuery();

        final List<Campaign> results = getJpaQuery(keywordQuery).getResultList();
        System.out.println(results);
        return results;
    }

    private FullTextQuery getJpaQuery(final Query luceneQuery) {
        return Search.getFullTextEntityManager(em).createFullTextQuery(luceneQuery, Campaign.class);
    }
}
