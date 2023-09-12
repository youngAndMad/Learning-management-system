import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";
import {SocialAccountLinkDTO} from "../domain/dto/socialAccountLink.dto";

@Injectable({
  providedIn: 'root'
})
export class SocialAccountLinkService {

  private http = inject(HttpClient);

  delete(
    id: number
  ): Observable<any> {
    return this
      .http.delete(`${API}/social-account-link/${id}`)
  }

  manage(
    socialAccountLinkDTO: SocialAccountLinkDTO
  ): Observable<any> {
    return this.http
      .post(`${API}/social-account-link`, socialAccountLinkDTO)
  }

}
