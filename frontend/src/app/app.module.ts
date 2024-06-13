import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SearchMemberComponent} from './components/search-member/search-member.component';
import {provideHttpClient, withInterceptorsFromDi} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MemberDetailsComponent} from './components/member-details/member-details.component';


@NgModule({
  declarations: [
    AppComponent,
    SearchMemberComponent,
    MemberDetailsComponent
  ],
  bootstrap: [AppComponent], imports: [BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule], providers: [provideHttpClient(withInterceptorsFromDi())]
})
export class AppModule {
}
