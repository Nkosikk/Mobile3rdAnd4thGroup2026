#!/usr/bin/env bash

set -euo pipefail

appium --log appium.log >/dev/null 2>&1 &
APPIUM_PID=$!

cleanup() {
  kill "$APPIUM_PID" 2>/dev/null || true
  wait "$APPIUM_PID" 2>/dev/null || true
}
trap cleanup EXIT

for attempt in $(seq 1 30); do
  if curl --fail --silent http://127.0.0.1:4723/status >/dev/null; then
    break
  fi
  sleep 2
done

curl --fail --silent --show-error http://127.0.0.1:4723/status >/dev/null
mvn --batch-mode --no-transfer-progress -Dtest=basicTests.NotInstalledApp test
