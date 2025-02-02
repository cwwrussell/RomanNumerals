import { type ChangeEvent, type FC, useCallback } from "react";
import styles from "./text-box.module.scss";
import cx from "classnames";

interface Props {
  error?: boolean;
  value: string;
  placeholder?: string;

  onChange(_value: string): void;
}

const TextBox: FC<Props> = (props) => {
  const onChange = useCallback((event: ChangeEvent<HTMLInputElement>) => {
    const newValue = event.target.value;
    props.onChange(newValue);
  }, []);

  return (
    <input
      className={cx(styles.TextBox, { [styles.error]: props.error })}
      placeholder={props.placeholder}
      value={props.value ?? ""}
      onChange={onChange}
    />
  );
};

export default TextBox;
