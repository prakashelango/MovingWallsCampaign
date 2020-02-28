import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-campaign-component',
  templateUrl: './campaign.component.html',
  styleUrls: ['./campaign.component.scss']
})
export class CampaignComponent implements OnInit {
  displayedColumns: string[] = ['name', 'duration', 'status', 'addtionalMsg'];
  dataSource = new MatTableDataSource<campaignDetails>(ELEMENT_DATA);

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    console.log("MOHAN datasource", this.dataSource)
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}

export interface campaignDetails {
  name: string;
  duration: string;
  status: string;
  addtionalMsg: string;
}

const ELEMENT_DATA: campaignDetails[] = [
  {name: "Focus Media", duration: "01-Apr - 31-Apr-2020", status: "Published", addtionalMsg: "Available in 2 days"},
  {
    name: "Ochard - 3 Billboards",
    duration: "01-Apr - 31-Apr-2020",
    status: "OnGoing",
    addtionalMsg: "Available in 2 days"
  },
  {name: "Focus Media", duration: "01-Apr - 31-Apr-2020", status: "Published", addtionalMsg: "Available in 2 days"}
];
