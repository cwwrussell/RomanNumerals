import React, { type FC, type PropsWithChildren } from "react";
import styles from "./button.module.scss";
import cx from "classnames";

interface Props extends PropsWithChildren {
  className?: string;
  disabled?: boolean;

  onClick(): void;
}

const Button: FC<Props> = (props) => {
  const { disabled, children, onClick } = props;

  return (
    <button
      className={cx(props.className, styles.Button)}
      disabled={disabled}
      onClick={onClick}
    >
      {children}
    </button>
  );
};

export default Button;
