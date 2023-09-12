import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";
import {CourseDTO} from "../domain/dto/course.dto";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private http = inject(HttpClient)

  delete(
    id: number
  ): Observable<any> {
    return this.http
      .delete(`${API}/course/` + id)
  }

  find(
    id: number
  ): Observable<any> {
    return this.http
      .get(`${API}/course/` + id)
  }

  save(
    courseDTO: CourseDTO
  ):Observable<any>{
    return this.http
      .post(`${API}/course`,courseDTO)
  }
}
