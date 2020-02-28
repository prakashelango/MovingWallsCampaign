package com.base.movingwalls.campaignsearch;

import com.base.movingwalls.model.campaign.Campaign;
import com.base.movingwalls.repository.CampaignRepositoryEntityManagedImpl;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CampaignLucenceSearch {

    @Autowired(required = true)
    private CampaignRepositoryEntityManagedImpl campaignRepository;

    private List<Campaign> campaigns;

    @Before
    public void setupTestData() {

       campaigns = campaignRepository.dummyCampaignData();
    }

    @Commit
    @Test
    public void testA_whenInitialTestDataInserted_thenSuccess() {
            campaignRepository.createDummyCampaign();

    }

    @Test
    public void testB_whenIndexInitialized_thenCorrectIndexSize() throws InterruptedException {

        int indexSize = campaignRepository.initIndex();

        assertEquals(campaigns.size() - 1, indexSize);
    }

    @Test
    public void testE_whenKeywordSearchOnName_thenCorrectMatches() {
        List<Campaign> expected = campaigns;
        List<Campaign> results = campaignRepository.searchByCampaignData("Orchard Campaign");

        assertThat(results, containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void testE_PullAllRecords_thenMatches_with_Index() {
        List<Campaign> expected = campaigns;
        List<Campaign> results = campaignRepository.fetchAllCampaignData();

        assertThat(results, containsInAnyOrder(expected.toArray()));
    }

}
