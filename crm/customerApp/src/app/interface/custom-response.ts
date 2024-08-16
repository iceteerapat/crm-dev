import { Customer } from "./customer";

export interface CustomResponse{
    timeStamp: Date;
    statusCode: number;
    status: string;
    reason: string;
    message: string;
    developerMessage: string;
    data: {
        customers?: Customer[], customer?: Customer
    };
}