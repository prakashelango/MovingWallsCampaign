package com.base.movingwalls.repository;

import com.base.movingwalls.model.campaign.Campaign;

public interface CampaignRepositoryEntityManaged {

    void refresh(Campaign campaign);
}
