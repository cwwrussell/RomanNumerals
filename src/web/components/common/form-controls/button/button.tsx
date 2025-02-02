import React, { type FC, type PropsWithChildren } from "react";
import styles from "./button.module.scss";

interface Props extends PropsWithChildren {
  disabled?: boolean;

  onClick(): void;
}

const Button: FC<Props> = (props) => {
  const { disabled, children, onClick } = props;

  return (
    <button className={styles.Button} disabled={disabled} onClick={onClick}>
      {children}
    </button>
  );
};

export default Button;
