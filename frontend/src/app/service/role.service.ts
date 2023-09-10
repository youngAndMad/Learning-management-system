import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Role} from "../domain/enum/Role";
import {Observable} from "rxjs";
import {API} from "../config/config";

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  private http = inject(HttpClient)

  assign(
    userId: number,
    role: Role
  ): Observable<any> {
    return this.http.post(`${API}/role/assign`, {}, {
      params: {
        'user_id': userId,
        'role': role
      }
    })
  }

  deprive(
    userId: number,
    role: Role
  ): Observable<any> {
    return this.http.post(`${API}/role/deprive`, {}, {
      params: {
        'user_id': userId,
        'role': role
      }
    })
  }
}
