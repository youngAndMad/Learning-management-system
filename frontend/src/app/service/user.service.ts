import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private http = inject(HttpClient)

  register(
    req: any
  ): Observable<any> {
    return this.http
      .post(`${API}/user/`, req)
  }

  delete(
    id:number
  ):Observable<any>{
    return this.http
      .delete(`${API}/user/${id}`)
  }
}
