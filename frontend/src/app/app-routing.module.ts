import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SearchMemberComponent} from "./components/search-member/search-member.component";

const routes: Routes = [
  {path: "", component: SearchMemberComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
