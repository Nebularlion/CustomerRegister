import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';
import { ExportCsvService } from 'src/app/services/export-csv.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ModalComponent } from '../modal/modal.component';
import { CompanyService } from 'src/app/services/company.service';
import { Company } from 'src/app/models/company';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss'],
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];
  companies: Company[];
  dialogRef: any;
  constructor(
    private customerService: CustomerService,
    private companyService: CompanyService,
    private csvService: ExportCsvService,
    public dialog: MatDialog
  ) {
    this.customers = [];
    this.companies = [];
  }

  ngOnInit(): void {
    this.customerService.findAllCustomers().subscribe((customers) => {
      this.customers = customers;
    });

    this.companyService.findAllCompanies().subscribe((companies) => {
      this.companies = companies;
    });
  }

  exportCsv(): void {
    this.csvService.exportCsv();
  }

  openDialog(): void {
    this.dialogRef = this.dialog.open(ModalComponent, {
      width: '500px',
      data: {
        companies: this.companies,
      },
    });

    this.dialogRef.afterClosed().subscribe(() => {
      this.ngOnInit();
    });
  }
}
