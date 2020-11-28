import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResponsaveisService {
  apiUrl = environment.URLSERVIDOR + "responsavel";

  constructor(private httpClient: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
  salvar(responsavel: any): Observable<any> {
    return this.httpClient.post<any>(this.apiUrl, JSON.stringify(responsavel), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError))
  }

  listar(): Observable<any> {
    return this.httpClient.get<any>(environment.URLSERVIDOR + "responsavel");
  }

  // Manipulação de erros
  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}