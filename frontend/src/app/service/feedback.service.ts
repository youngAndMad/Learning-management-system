import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";
import {FeedbackDTO} from "../domain/dto/feedback.dto";

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  private http = inject(HttpClient)

  find(
    id: number
  ): Observable<any> {
    return this.http.get(`${API}/feedback/` + id)
  }

  delete(
    id: number
  ): Observable<any> {
    return this.http.delete(`${API}/feedback/` + id)
  }

  doFeedback(
    courseId: number,
    feedbackDTO: FeedbackDTO
  ): Observable<any> {
    return this.http.post(`${API}/feedback`, feedbackDTO, {
        params: {'course_id': courseId}
      }
    );
  }

  getUserFeedbacks(
    id: number
  ): Observable<any> {
    return this.http.get(`${API}/feedback/`, {params: {'user_id': id}})
  }


}
