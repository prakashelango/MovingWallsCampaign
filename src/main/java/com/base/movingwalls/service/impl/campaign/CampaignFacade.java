package com.base.movingwalls.service.impl.campaign;

import com.base.movingwalls.common.core.FunctionUtils;
import com.base.movingwalls.common.core.Promise;
import com.base.movingwalls.common.core.React;
import com.base.movingwalls.common.core.Reader;
import com.base.movingwalls.model.campaign.CampaignInfo;
import com.base.movingwalls.repository.CampaignRepositoryEntityManagedImpl;

import java.util.List;

public class CampaignFacade {

    /**
     * @param searchData
     * @return
     */
    public static Reader<CampaignRepositoryEntityManagedImpl, Promise<List<CampaignInfo>>> searchByCampaignData(final String searchData) {
        return Reader.of(managedImpl -> React.of(() -> searchData)
                .then(managedImpl::searchByCampaignData)
                .then(FunctionUtils.asList(CampaignConverter::convertToInfo))
                .getPromise());
    }

    /**
     * @return
     */
    public static Reader<CampaignRepositoryEntityManagedImpl, Promise<List<CampaignInfo>>> findAllCampaignData() {
        return Reader.of(managedImpl -> React.of(() -> managedImpl.fetchAllCampaignData())
                .then(FunctionUtils.asList(CampaignConverter::convertToInfo))
                .getPromise());
    }


}
