import ServicePayload from "@models/service-payload";

/*
These checks could certainly be implemented on an as needed basis,
these util functions just provide a way to make write self documenting code.
*/

/**
 * determines whether the service succeeded
 * @param data
 */
const succeeded = <T>(data: ServicePayload<T>): boolean =>
  data !== null && data !== undefined;

/**
 * determines whether the service failed
 * @param data
 */
const failed = <T>(data: ServicePayload<T>): boolean => data === null;

/**
 * determines whether a service payload is in the 'pending' or 'default' state
 * @param data
 */
const pending = <T>(data: ServicePayload<T>): boolean => data === undefined;

const ServiceUtils = {
  succeeded,
  failed,
  pending,
};

export default ServiceUtils;
