import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SearchMemberComponent} from "./components/search-member/search-member.component";
import {MemberDetailsComponent} from "./components/member-details/member-details.component";

const routes: Routes = [
  {path: "", component: SearchMemberComponent},
  {path: "member-details/:id", component: MemberDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
