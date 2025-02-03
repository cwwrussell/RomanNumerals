export enum NotificationType {
  ERROR,
  INFO,
  SUCCESS,
}

interface Notification {
  id?: string;
  title?: string;
  type: NotificationType;
  message: string;
}

export default Notification;
