import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, Subscriber, tap, throwError } from 'rxjs';
import { CustomResponse } from '../interface/custom-response';
import { Customer } from '../interface/customer';
import { Status } from '../enumuration/status.enum';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  private readonly apiUrl = 'any';

  constructor(private http: HttpClient) {}

  customers$ = <Observable<CustomResponse>>this.http.get<CustomResponse>(`${this.apiUrl}/customer/list`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  save$ = (customer : Customer) => <Observable<CustomResponse>>this.http.post<CustomResponse>(`${this.apiUrl}/customer/save`, customer)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  filter$ = (status: Status, response : CustomResponse) => <Observable<CustomResponse>>new Observable<CustomResponse>(
    suscriber => {
      console.log(response);
      suscriber.next(
        status === Status.ALL ? {...response, message: `Customers filtered by ${status} status`}
      )
    }
  )
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  delete$ = (id: number) => <Observable<CustomResponse>>this.http.delete<CustomResponse>(`${this.apiUrl}/customer/delete/${id}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );
  

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error)
    return throwError(`An error was occured - Error code: ${error.status}`);
  }

}
