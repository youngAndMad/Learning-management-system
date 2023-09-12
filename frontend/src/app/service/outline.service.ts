import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OutlineDTO} from "../domain/dto/outline.dto";
import {API} from "../config/config";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OutlineService {

  private http = inject(HttpClient)

  update(
    id: number,
    dto: OutlineDTO
  ): Observable<any> {
    return this.http
      .patch(`${API}/outline/` + id, dto)
  }

  delete(
    id: number
  ): Observable<any> {
    return this.http.delete(`${API}/outline/` + id);
  }

}
