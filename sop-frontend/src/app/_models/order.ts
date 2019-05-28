import { User } from './user';
import { Product } from './product';

export class Order {
    id: number;
    name: string;
    address: string;
    courierId: number;
    customerId: number;
    orderStatus: string;
    products: Array<Product>;
    total: number;
}
