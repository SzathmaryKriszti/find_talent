import {Component, OnDestroy, OnInit} from '@angular/core';
import {SearchService} from "../../services/search.service";
import {ActivatedRoute} from "@angular/router";
import {MemberDetailsItemModel} from "../../models/member-details-item.model";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-member-details',
  templateUrl: './member-details.component.html',
  styleUrls: ['./member-details.component.css']
})
export class MemberDetailsComponent implements OnInit, OnDestroy {

  id: any = 0;
  language: string = '';
  memberDetails!: MemberDetailsItemModel;
  private loadMemberDetailsSubscription: Subscription | undefined;
  private paramSubscription: Subscription | undefined;
  private queryParamSubscription: Subscription | undefined;


  constructor(private searchService: SearchService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnDestroy(): void {
    this.loadMemberDetailsSubscription?.unsubscribe();
    this.paramSubscription?.unsubscribe();
    this.queryParamSubscription?.unsubscribe();
  }

  ngOnInit(): void {
    this.paramSubscription = this.activatedRoute.paramMap.subscribe(paramResponse => {
      this.id = paramResponse.get('id');
    });
    this.queryParamSubscription = this.activatedRoute.queryParams.subscribe(
      params => {
        this.language = params['language'];
      }
    );
    this.loadMemberDetails(this.id);
  }

  loadMemberDetails(id: number) {
    this.loadMemberDetailsSubscription = this.searchService.loadMemberDetails(id).subscribe({
      next: value => this.memberDetails = this.memberDetails = value,
      error: err => console.error(err)
    });
  }

  back() {
    history.back()
  }
}
