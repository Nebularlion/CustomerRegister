import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss'],
})
export class ModalComponent {
  companies = this.data.companies;
  customerForm = this.formBuilder.group({
    firstName: '',
    lastName: '',
    address: '',
    companyId: -1,
  });

  constructor(
    public dialogRef: MatDialogRef<ModalComponent>,
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    @Inject(MAT_DIALOG_DATA) public data: { companies: any }
  ) {}

  onSubmit(): void {
    this.customerService
      .addCustomer(this.customerForm.value)
      .subscribe(() => this.dialogRef.close());
  }
}
