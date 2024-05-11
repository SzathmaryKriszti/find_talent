import {Component, OnInit} from '@angular/core';
import {SearchService} from "../../services/search.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-member-details',
  templateUrl: './member-details.component.html',
  styleUrls: ['./member-details.component.css']
})
export class MemberDetailsComponent implements OnInit {

  id: any = 0;

  constructor(private searchService: SearchService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(paramResponse => {
      this.id = paramResponse.get('id');
    })
  }

  ngOnInit(): void {
    this.loadMemberDetails(this.id);
  }

  loadMemberDetails(id: number) {
    this.searchService.loadMemberDetails(id)
  }
}
