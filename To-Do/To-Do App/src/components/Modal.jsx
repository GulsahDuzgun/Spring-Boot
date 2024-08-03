import { useTasks } from "../utils/ContextApi";

export default function Modal(id, message, executedFunc) {
  const { isModalOpen, setIsModalOpen } = useTasks();
  if (isModalOpen) return <div>Modal</div>;
}
