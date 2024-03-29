import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";
import {UserDTO} from "../domain/dto/user.dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private http = inject(HttpClient)

  register(
    userDTO: UserDTO
  ): Observable<any> {
    return this.http
      .post(`${API}/user/`, userDTO)
  }

  delete(
    id: number
  ): Observable<any> {
    return this.http
      .delete(`${API}/user/${id}`)
  }
}
