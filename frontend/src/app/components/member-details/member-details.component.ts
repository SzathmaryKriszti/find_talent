import {Component, OnInit} from '@angular/core';
import {SearchService} from "../../services/search.service";
import {ActivatedRoute} from "@angular/router";
import {MemberDetailsItemModel} from "../../models/member-details-item.model";

@Component({
    selector: 'app-member-details',
    templateUrl: './member-details.component.html',
    styleUrls: ['./member-details.component.css']
})
export class MemberDetailsComponent implements OnInit {

    id: any = 0;
    language: string = '';
    memberDetails!: MemberDetailsItemModel;


    constructor(private searchService: SearchService,
                private activatedRoute: ActivatedRoute) {
        this.activatedRoute.paramMap.subscribe(paramResponse => {
            this.id = paramResponse.get('id');
        })
        this.activatedRoute.queryParams.subscribe(
            params => {
                this.language = params['language'];
            }
        );
    }

    ngOnInit(): void {
        this.loadMemberDetails(this.id);
    }

    loadMemberDetails(id: number) {
        this.searchService.loadMemberDetails(id).subscribe({
            next: value => this.memberDetails = this.memberDetails = value,
            error: err => console.error(err)
        });
    }

    back() {
        history.back()
    }
}
