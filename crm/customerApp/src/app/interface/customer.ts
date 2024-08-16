import { Status } from "../enumuration/status.enum";

export interface Customer {
    uniqueId: number;
    name: string;
    surName: string;
    id: number;
    address1: string;
    address2: string;
    phoneNo: string;
    custStatus: Status;
    imageProfile: string;
    email: string;
    dateOfBirth: string;
    acctNo: string;
}
