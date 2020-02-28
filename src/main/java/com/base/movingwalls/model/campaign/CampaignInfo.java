package com.base.movingwalls.model.campaign;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(value = "Campaign Data", description = "API Data Model Provides Campaign Data.")
public class CampaignInfo {

    @ApiModelProperty(notes = "Name of Campaign")
    private String name;

    @ApiModelProperty(notes = "Duration of Campaign")
    private String duration;

    @ApiModelProperty(notes = "Status of Campaign ex: Processing, Completed, Published, Ongoing, etc..")
    private String status;

    @ApiModelProperty(notes = "Date of Campaign starts. Accepts Date")
    private LocalDateTime startDate;

    @ApiModelProperty(notes = "Date of Campaign end. Accepts Date")
    private LocalDateTime endDate;

    @ApiModelProperty(notes = "Provides the Report Status")
    private String report;

}
