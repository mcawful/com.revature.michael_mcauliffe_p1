ALTER TABLE "employee" DROP CONSTRAINT IF EXISTS "employee_fk0";

ALTER TABLE "credential" DROP CONSTRAINT IF EXISTS "credential_fk0";

ALTER TABLE "request" DROP CONSTRAINT IF EXISTS "request_fk0";

ALTER TABLE "message" DROP CONSTRAINT IF EXISTS "message_fk0";

ALTER TABLE "message" DROP CONSTRAINT IF EXISTS "message_fk1";

ALTER TABLE "message" DROP CONSTRAINT IF EXISTS "message_fk2";

ALTER TABLE "attachment" DROP CONSTRAINT IF EXISTS "attachment_fk0";

ALTER TABLE "approval" DROP CONSTRAINT IF EXISTS "approval_fk0";

ALTER TABLE "approval" DROP CONSTRAINT IF EXISTS "approval_fk1";

ALTER TABLE "approval" DROP CONSTRAINT IF EXISTS "approval_fk2";

ALTER TABLE "approval" DROP CONSTRAINT IF EXISTS "approval_fk3";

DROP TABLE IF EXISTS "employee";

DROP TABLE IF EXISTS "credential";

DROP TABLE IF EXISTS "request";

DROP TABLE IF EXISTS "message";

DROP TABLE IF EXISTS "attachment";

DROP TABLE IF EXISTS "approval";
