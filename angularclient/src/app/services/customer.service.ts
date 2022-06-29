import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Customer } from '../models/customer';
import { CustomerCreationDTO } from '../models/customerCreationDTO';

@Injectable()
export class CustomerService {
  private customerUrl: string;
  constructor(private http: HttpClient) {
    this.customerUrl = 'http://localhost:8080';
  }

  public findAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customerUrl + '/customers');
  }

  public addCustomer(customer: CustomerCreationDTO) {
    return this.http.post<CustomerCreationDTO>(
      this.customerUrl + '/addcustomer',
      customer
    );
  }
}
