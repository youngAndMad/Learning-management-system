import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {API} from "../config/config";
import {AttachmentSource} from "../domain/enum/AttachmentSource";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  private http = inject(HttpClient)

  deleteObject(
    req: any
  ): Observable<any> {
    return this
      .http.patch(`${API}/storage/delete`, req)
  }

  upload(
    file: File,
    name: string,
    target: number,
    source: AttachmentSource,
  ): Observable<any> {
    let formData = new FormData();
    formData.append('file', file);
    formData.append('name', name);
    formData.append('target', target.toString());
    formData.append('source', source);

    return this.http
      .post(`${API}/storage/upload`, formData)
  }

  download(
    name: string,
    target: number,
    source: AttachmentSource,
  ): Observable<any> {
    return this.http.get(
      `${API}/storage/download`, {
        params: {
          'name': name,
          'target': target,
          'source': source
        }
      }
    )
  }
}
