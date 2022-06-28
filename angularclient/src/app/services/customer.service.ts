import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Customer } from '../models/customer';

@Injectable()
export class CustomerService {
  private customerUrl: string;
  constructor(private http: HttpClient) {
    this.customerUrl = 'http://localhost:8080/customers';
  }

  public findAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customerUrl);
  }
}
