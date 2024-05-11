import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MemberDetailsItemModel} from "../models/member-details-item.model";

const BASE_URL: string = 'http://localhost:8080/api/searches'

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http : HttpClient) { }

  search(language: string):Observable<Array<MemberDetailsItemModel>>{
    return this.http.get<Array<MemberDetailsItemModel>>(`${BASE_URL}/member?language=${language}`)
  }
}