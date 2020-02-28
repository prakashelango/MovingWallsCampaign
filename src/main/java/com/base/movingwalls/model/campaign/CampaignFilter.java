package com.base.movingwalls.model.campaign;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(value = "Campaign Filter", description = "API Info Used to provide filter's for campaign.")
public class CampaignFilter {

    @ApiModelProperty(notes = "Mode of Campaign ex: All, Completed, Ongoing, Historical")
    private String campaignMode;

    @ApiModelProperty(notes = "Search based on Campaign Name")
    private String campaignSearchKeyWord;

    @ApiModelProperty(notes = "Location of Campaign ex: Maharastra, Mumbai, Illinois, New York")
    private String campaignlocation;

    @ApiModelProperty(notes = "Date of Campaign Occur ex: Last Month, Next Month")
    private LocalDateTime campaignDate;

    @ApiModelProperty(notes = "Sortable by Campaign")
    private String sortby;

}
