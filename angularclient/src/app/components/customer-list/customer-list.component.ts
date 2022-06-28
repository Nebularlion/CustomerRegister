import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss'],
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];

  constructor(private customerService: CustomerService) {
    this.customers = [];
  }

  ngOnInit(): void {
    this.customerService.findAllCustomers().subscribe((data) => {
      this.customers = data;
      console.log('asdasd', this.customers);
    });
  }
}
