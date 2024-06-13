import {Component, OnDestroy, OnInit} from '@angular/core';
import {SearchService} from "../../services/search.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MemberDetailsItemModel} from "../../models/member-details-item.model";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-search-member',
  templateUrl: './search-member.component.html',
  styleUrls: ['./search-member.component.css']
})
export class SearchMemberComponent implements OnInit, OnDestroy {

  members: Array<MemberDetailsItemModel> = [];
  searchForm!: FormGroup
  errorMessage: Boolean = false;
  private searchSubscription: Subscription | undefined;
  private queryParamSubscription: Subscription | undefined;

  constructor(private searchService: SearchService,
              private formBuilder: FormBuilder,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.searchForm = formBuilder.group({
      language: ['', Validators.required]
    })
  }

  ngOnDestroy(): void {
    this.searchSubscription?.unsubscribe();
    this.queryParamSubscription?.unsubscribe();
  }

  ngOnInit(): void {
   this.queryParamSubscription = this.activatedRoute.queryParams.subscribe(
      params => {
        this.searchForm.controls['language'].setValue(params['language'])
      }
    );
    this.search();
  }


  search() {
    if (this.searchForm.get('language')?.value) {
      this.searchSubscription = this.searchService.search(this.searchForm.get('language')?.value).subscribe({
        next: (value) => {
          if (value.length === 0) {
            this.errorMessage = true
          } else {
            this.errorMessage = false
            this.members = this.members = value
            this.router.navigate([''], {queryParams: {language: this.searchForm.get('language')?.value}})
          }
        },
        error: err => console.error(err)
      });
    }
  }

  loadRepos(id: number) {
    this.router.navigate(["/member-details/" + id], {queryParams: {language: this.searchForm.get('language')?.value}});
  }
}
