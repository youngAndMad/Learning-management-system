import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {API} from "../config/config";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QrService {

  private http = inject(HttpClient)

  getCode(
    data: string
  ): Observable<any> {
    return this.http.get(
      `${API}/qr-service/qr-code?data=` + data
    )
  }

}
