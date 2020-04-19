#!/bin/bash

backend/project-website-0.1/bin/project-website  server backend/project-website-0.1/config.yml &
npm start --prefix frontend/ &
haproxy -f haproxy/haproxy.cfg