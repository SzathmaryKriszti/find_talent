import {Component, OnInit} from '@angular/core';
import {SearchService} from "../../services/search.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MemberDetailsItemModel} from "../../models/member-details-item.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search-member',
  templateUrl: './search-member.component.html',
  styleUrls: ['./search-member.component.css']
})
export class SearchMemberComponent implements OnInit {

  members: Array<MemberDetailsItemModel> = [];
  searchForm!: FormGroup
  language: string = '';

  constructor(private searchService: SearchService,
              private formBuilder: FormBuilder,
              private router: Router) {
    this.searchForm = formBuilder.group({
      language: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  search() {
    this.searchService.search(this.searchForm.get('language')?.value).subscribe({
      next: (value) => {
        this.members = this.members = value
      },
      error: err => console.error(err)
    });
  }

  loadRepos(id: number) {
    this.router.navigate(["/member-details/" + id]);
  }
}
