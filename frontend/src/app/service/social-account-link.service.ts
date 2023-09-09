import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";

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
    req: any
  ): Observable<any> {
    return this.http
      .post(`${API}/social-account-link`, req)
  }

}
