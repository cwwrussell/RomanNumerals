type ServicePayload<T> =
  | T // service success payload
  | null // service failure payload
  | undefined; // service not attempted; default state

export default ServicePayload;
