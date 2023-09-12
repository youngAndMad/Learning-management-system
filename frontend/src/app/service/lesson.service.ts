import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";
import {LessonDTO} from "../domain/dto/lesson.dto";

@Injectable({
  providedIn: 'root'
})
export class LessonService {

  private http = inject(HttpClient)

  find(
    id: number
  ): Observable<any> {
    return this.http
      .get(`${API}/lesson/` + id)
  }

  delete(
    id: number
  ): Observable<any> {
    return this.http
      .delete(`${API}/lesson/` + id)
  }

  update(
    id: number,
    lessonDTO: LessonDTO
  ): Observable<any> {
    return this.http
      .patch(`${API}/lesson/` + id, lessonDTO);
  }


}
